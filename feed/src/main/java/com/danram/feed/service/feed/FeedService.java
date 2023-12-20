package com.danram.feed.service.feed;

import com.danram.feed.dto.request.FeedEditRequestDto;
import com.danram.feed.dto.request.feed.FeedAddRequestDto;
import com.danram.feed.dto.response.FeedEditResponseDto;
import com.danram.feed.dto.response.feed.FeedAddResponseDto;
import com.danram.feed.dto.response.feed.FeedAllInfoResponseDto;
import com.danram.feed.dto.response.feed.FeedLikeResponseDto;

import java.util.List;

public interface FeedService {
    public FeedAddResponseDto addFeed(FeedAddRequestDto dto, List<String> files);
    public List<FeedAllInfoResponseDto> findAll(Long page);
    public FeedEditResponseDto editFeed(FeedEditRequestDto dto, String img);
    public String deleteFeed(Long feedId);
    public FeedLikeResponseDto likeFeed(Long feedId);
    public FeedLikeResponseDto unlikeFeed(final Long feedId);
}
