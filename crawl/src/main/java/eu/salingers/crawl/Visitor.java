package eu.salingers.crawl;

import java.util.List;

public class Visitor {
  Member member;

  List<String> visits;

  public static class Builder {
    private Member member;

    private List<String> visits;

    public Builder member(Member member) {
      this.member = member;
      return this;
    }

    public Builder visits(List<String> visits) {
      this.visits = visits;
      return this;
    }

    public Visitor build() {
      return new Visitor(this);
    }
  }

  private Visitor(Builder builder) {
    this.member = builder.member;
    this.visits = builder.visits;
  }
}
