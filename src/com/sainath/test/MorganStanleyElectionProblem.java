package com.sainath.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
decide winner of the election.
findWinner(List<Candidate>, List<Vote>
Candidate -> id and name
Vote -> voterId, candidateId
Person who gets max votes will win
In case of tie candidate with long name will win
 */
public class MorganStanleyElectionProblem {

    static class Candidate {
        private int id;
        private String name;

        public Candidate(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Candidate candidate = (Candidate) o;
            return id == candidate.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return "Candidate{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class Vote {
        private int voterId;
        private int candidateId;

        public Vote(int voterId, int candidateId) {
            this.voterId = voterId;
            this.candidateId = candidateId;
        }
    }

    public static Candidate findWinner(List<Candidate> candidates, List<Vote> votes) {
        Candidate winner = null;

        // Find votes share for each candidate using Map<Candidate, Integer>

        Map<Integer, Integer> map = new HashMap<>();
        //Set<Candidate> candidateSet = new HashSet<>(candidates);
        for (Vote vote : votes) {
            if (!map.containsKey(vote.candidateId)) {
                map.put(vote.candidateId, 1);
            } else {
                map.put(vote.candidateId, map.get(vote.candidateId) + 1);
            }
        }
        Map<Candidate, Integer> voteShare = new HashMap<>(candidates.stream()
                                                                    .filter(candidate -> candidate != null && map.containsKey(candidate.id))
                                                                    .collect(Collectors.toMap(candidate -> candidate, candidate -> map.get(candidate.id))));
        /*for (Candidate candidate : candidates) {
            if (map.containsKey(candidate.id)) {
                if (!voteShare.containsKey(candidate)) {
                    voteShare.put(candidate, map.get(candidate.id));
                }
            }
        }*/

        Comparator<Candidate> comparator = (c1, c2) -> {
            if (voteShare.get(c1).compareTo(voteShare.get(c2)) == 0) {
                //System.out.println("C2 = " + c2.name + ", C1 = " + c1.name);
                return c2.name.length() - c1.name.length();
            }
            return voteShare.get(c2).compareTo(voteShare.get(c1));
        };
        Set<Candidate> candidateSet = new TreeSet<>(comparator);
        candidateSet.addAll(voteShare.keySet());
        //System.out.println(candidateSet);

        return candidateSet.stream().findFirst().get();
    }

    public static void main(String[] args) {
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate(1, "ABC"));
        candidates.add(new Candidate(2, "XYZ"));
        candidates.add(new Candidate(3, "PQRS"));
        candidates.add(new Candidate(4, "MNOPQ"));
        candidates.add(new Candidate(5, "A"));
        candidates.add(null);

        List<Vote> votes = new ArrayList<>();
        votes.add(new Vote(1, 2));
        votes.add(new Vote(2, 1));
        votes.add(new Vote(3, 2));
        votes.add(new Vote(4, 1));
        votes.add(new Vote(5, 1));
        votes.add(new Vote(6, 3));
        votes.add(new Vote(7, 3));
        votes.add(new Vote(8, 3));
        votes.add(new Vote(9, 3));
        votes.add(new Vote(10, 4));
        votes.add(new Vote(11, 4));
        votes.add(new Vote(12, 4));
        votes.add(new Vote(13, 4));
        votes.add(new Vote(14, 4));
        votes.add(new Vote(15, 3));
        votes.add(new Vote(16, 5));
        votes.add(new Vote(17, 5));
        votes.add(new Vote(18, 5));
        votes.add(new Vote(19, 5));
        //votes.add(new Vote(20, 5));
        //votes.add(new Vote(21, 5));

        Candidate winner = findWinner(candidates, votes);
        System.out.println(winner);
    }

}
