package eu.salingers.tooling.team;

@FunctionalInterface
interface Conversion{
  Member getByName(Team team, String name);
}