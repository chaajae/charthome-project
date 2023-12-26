package com.charthome.reply.model.service;

import com.charthome.reply.model.dto.ReplyDto;
import com.charthome.reply.model.entity.ReplyEntity;
import com.charthome.reply.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

    private final ReplyRepository replyRepository;

    @Override
    public void replySave(ReplyDto reply) {
        ReplyEntity entity = ReplyEntity.toEntity(reply);
        replyRepository.save(entity);
    }

//    @Override
//    public List<ReplyDto> replyList(Long boardNo) {
//        List<ReplyEntity> entityList = replyRepository.findAllByBoard(boardNo);
//        List<ReplyDto> replyList = new ArrayList<>();
//        for (ReplyEntity entity : entityList) {
//            replyList.add(ReplyDto.toDto(entity));
//        }
//        return replyList;
//    }
}
