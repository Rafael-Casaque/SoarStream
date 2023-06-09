package com.quickQuack.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quickQuack.domain.model.Comment;
import com.quickQuack.domain.model.Like;
import com.quickQuack.domain.model.Message;
import com.quickQuack.domain.model.User;
import com.quickQuack.repositories.MessageRepository;
import com.quickQuack.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

     @PostMapping
    public ResponseEntity<Object> createComment(@RequestBody CreateCommentRequest request) {
        String username = request.getUsername();
        String content = request.getContent();
        String messageId = request.getMessageId();

        if (messageId == null || username == null || content == null) {
            return ResponseEntity.status(422).body("parâmetros ausentes na requisição");
        }

        Optional<User> checkUser = userRepository.findById(username);
        if (!checkUser.isPresent()) {
            return ResponseEntity.status(404).body("usuário não encontrado na base de dados");
        }

        Optional<Message> checkMessage = messageRepository.findById(messageId);
        if (!checkMessage.isPresent()) {
            return ResponseEntity.status(404).body("mensagem não encontrada na base de dados");
        }

        LocalDate now = LocalDate.now();

        ArrayList<Like> likeList = new ArrayList<>();
        ArrayList<Comment> commentList = new ArrayList<>();

        Comment comment = new Comment(username + UUID.randomUUID().toString(), checkUser.get(), content,
                now, likeList, commentList);
        checkMessage.get().getCommentList().add(comment);
        messageRepository.save(checkMessage.get());

        return ResponseEntity.ok(checkMessage.get());
    }

}
