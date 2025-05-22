package com.study.board.repository;

import com.study.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> { // extends 상속받음. JpaRepository를 상속받아 타입지정.

    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
}
