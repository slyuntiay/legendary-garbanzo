package training.string;

import java.util.HashSet;

public class VotingSystem {
    HashSet<Candidate> candidates= new HashSet<Candidate>();

    public void addCandidate (String candidateName) {
        Candidate candidate = new Candidate(candidateName);
        candidates.add(candidate);
        System.out.println(candidateName + " " + "добавлен в список");
    }

    public void voteFor(String candidateName){
    for(Candidate candidate : candidates){
       if (candidate.getCandidateName().equalsIgnoreCase(candidateName)) {
           candidate.addVotes();
           System.out.println("отдал голос за " + " " + candidate.getCandidateName());
           return;
       }
    }
    }
    public void getResult(){
        for(Candidate candidate : candidates){
            System.out.println(candidate);
        }
    }
   public void removeVote(String candidateName, int votes){
        for(Candidate candidate : candidates){

        }
   }

}
