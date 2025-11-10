package training.string;


import java.util.HashSet;

public class VotingSystem {
    HashSet<Candidate> candidates = new HashSet<Candidate>();

    public void addCandidate(String candidateName) {
        Candidate candidate = new Candidate(candidateName);
        candidates.add(candidate);
        System.out.println(candidateName + " " + "добавлен в список");
    }

    public void voteFor(String candidateName) {
        for (Candidate candidate : candidates) {
            if (candidate.getCandidateName().equalsIgnoreCase(candidateName)) {
                candidate.addVotes();
                System.out.println("отдал голос за " + " " + candidate.getCandidateName());
                return;
            }

        }
    }

    public void getStatistic() {
        int voteQuan = 0;
        for (Candidate candidate : candidates) {
            voteQuan += candidate.getVotes();
        }
        for (Candidate candidate : candidates) {
            System.out.printf("%s %.2f %%\n",candidate.getCandidateName(),(candidate.getVotes() / (double) voteQuan * 100.0) );
        }

    }

    public void getResult() {
        for (Candidate candidate : candidates) {
            System.out.println(candidate);
        }
        System.out.println();
    }

    public void removeVote(String candidateName) {
        for (Candidate candidate : candidates) {
            if (candidate.getCandidateName().equalsIgnoreCase(candidateName)) {
                candidate.removeVotes();
                System.out.println("забрал голос за " + " " + candidate.getCandidateName());
                return;
            }
        }
    }

    public void winner() {
        System.out.println("Победитель");
        int max = 0;
        int maxHash = 0;
        for (Candidate candidate : candidates) {
            if (candidate.getVotes() > max) {
                max = candidate.getVotes();
                maxHash = candidate.hashCode();
            }
        }
        for (Candidate candidate : candidates) {
            if (candidate.hashCode() == maxHash) {
                System.out.println(candidate);
            }
        }
    }
//    public static Integer maxForStream( HashSet<Candidate> candidates){
//        Integer max = candidates.stream().max(Integer::compare).get();
//        return max;
//    }

}
