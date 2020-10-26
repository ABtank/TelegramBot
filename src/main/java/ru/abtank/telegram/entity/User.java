package ru.abtank.telegram.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.abtank.telegram.bot.State;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "chat_id", name = "users_unique_chatid_idx")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractBaseEntity {
    @Column(name = "chat_id", unique = true, nullable = false)
    @NotNull
    private Integer chatId;

    @Column(name = "name", unique = true, nullable = false)
    @NotBlank
    private String name;

    @Column(name = "score", nullable = false)
    @NotNull
    private Integer score;

    @Column(name = "high_score", nullable = false)
    @NotNull
    private Integer highScore;

    @Column(name = "bot_state", nullable = false)
    @NotBlank
    private State botState;

    // Конструктор нужен для создания нового пользователя (а может и нет? :))
    public User(int chatId) {
        this.chatId = chatId;
        this.name = String.valueOf(chatId);
        this.score = 0;
        this.highScore = 0;
        this.botState = State.START;
    }



    public State getBotState() {
        return botState;
    }

    public void setBotState(State botState) {
        this.botState = botState;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getHighScore() {
        return highScore;
    }

    public void setHighScore(Integer highScore) {
        this.highScore = highScore;
    }
}