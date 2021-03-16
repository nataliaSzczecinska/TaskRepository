package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.*;

@RestController
@RequestMapping("/v1/trello")
@RequiredArgsConstructor
public class TrelloController {

    @Autowired
    private final TrelloClient trelloClient;

    /*@GetMapping("getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        final List<TrelloBoardDto> trelloBoardsOptional = trelloBoards.stream()
                .map(Optional::ofNullable)
                .map(e -> e.orElse(new TrelloBoardDto()))
                .collect(Collectors.toList());

        List <TrelloBoardDto> trelloBoardsWithKodilla = trelloBoards.stream()
                .filter(e -> e.getId() != null)
                .filter(e -> e.getName() != null)
                .filter(e -> e.getName().contains("Kodilla"))
                .collect(Collectors.toList());

        trelloBoardsWithKodilla.stream()
                .forEach(trello -> System.out.println(trello.getId() + " " + trello.getName()));

        //trelloBoards.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
        return trelloBoardsOptional;

        /*trelloBoards.forEach(trelloBoardDto -> {
            System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
        });
    }*/

    @GetMapping("getTrelloBoards")
    public void getTrelloBoards() {
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
        trelloBoards.forEach(trelloBoardDto -> {
            System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());

            System.out.println("This board contains lists: ");

            trelloBoardDto.getLists().forEach(trelloList -> {
                System.out.println(
                        trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()
                );
            });

        });
    }
}