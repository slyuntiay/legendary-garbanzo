package training.string;

public class MainCondidate {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.addCandidate("Олег1");
        votingSystem.addCandidate("Олег2");
        votingSystem.addCandidate("Олег3");
        votingSystem.addCandidate("Олег4");
        System.out.println();
        votingSystem.voteFor("Олег1");
        votingSystem.voteFor("Олег3");
        votingSystem.voteFor("Олег3");
        votingSystem.voteFor("Олег1");
        votingSystem.voteFor("Олег4");
        votingSystem.voteFor("Олег4");
        votingSystem.voteFor("Олег4");
        votingSystem.voteFor("Олег2");
        votingSystem.voteFor("Олег1");
        votingSystem.voteFor("Олег1");
        votingSystem.voteFor("Олег1");
        votingSystem.voteFor("Олег1");
        votingSystem.voteFor("Олег1");
        System.out.println();
        votingSystem.getResult();

        votingSystem.winner();

        votingSystem.getStatistic();
    }
}
