package com.volleytracker.tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Importa todas as anotações do Spring Web

import com.volleytracker.tracker.models.Team;
import com.volleytracker.tracker.services.TeamService;

// Indica que esta classe é um controlador REST (responde com JSON/XML diretamente)
@RestController
// Define o caminho base para todas as rotas deste controlador (ex: /team)
@RequestMapping("/team")
public class TeamController {

    // Injeta o serviço de Team para uso nos métodos
    @Autowired
    private TeamService teamService;

    // GET /team/{id} - Retorna um time pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Team> findById(@PathVariable Long id) {
        Team team = teamService.findById(id);
        if (team == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrado
        }

        return ResponseEntity.ok(team); // Retorna 200 com o time
    }

    // POST /team - Cria um novo time
    @PostMapping
    public ResponseEntity<Void> createTeam(@RequestBody Team team) {
        teamService.save(team); // Salva o time no banco
        return ResponseEntity.noContent().build(); // Retorna 204 (sem corpo)
    }

    // GET /team - Retorna todos os times cadastrados
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok().body(teamService.findAllTeam()); // 200 com a lista de times
    }

    // GET /team/search?name=Nome - Busca time pelo nome
    @GetMapping("/search")
    public ResponseEntity<Team> findByName(@RequestParam String name) {
        Team teamFound = teamService.findByName(name);
        if (teamFound == null) {
            return ResponseEntity.notFound().build(); // 404 se não encontrado
        }
        return ResponseEntity.ok(teamFound); // 200 com o time encontrado
    }

    // DELETE /team/{id} - Deleta um time por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        Team team = teamService.findById(id);
        if (team == null) {
            return ResponseEntity.notFound().build(); // 404 se o time não existe
        }

        teamService.deleteById(id); // Remove o time do banco
        return ResponseEntity.noContent().build(); // 204 - deletado com sucesso
    }

    // PUT /team/{id} - Atualiza um time existente
    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody Team teamDetails) {
        Team updated = teamService.update(id, teamDetails); // Atualiza o time com os novos dados
        return ResponseEntity.ok(updated); // Retorna o time atualizado (200)
    }

}
