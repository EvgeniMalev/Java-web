


public class TeamRestController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> listTeams() {
        return teamService.findAll();
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.save(team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteById(id);
    }
}
