package training.string;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Candidate {
    private String candidateName;
    private int votes;

    public Candidate(String candidateName) {
        this.candidateName = candidateName;
        this.votes = votes;
    }

    public void addVotes() {
        this.votes++;
    }

    public void removeVotes() {
        this.votes--;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateName='" + candidateName + '\'' +
                ", votes=" + votes +
                '}';
    }
}
//Создай систему для проведения голосования. Нужно отслеживать кандидатов, голоса и определять победителя.
//lvl 2:
//Сделать возможность отзыва голоса
//
//Добавить статистику (% голосов)
//lvl 3
//добавить список людей которые будут давать рандомные голоса
//....