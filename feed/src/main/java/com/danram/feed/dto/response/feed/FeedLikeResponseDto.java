package com.danram.feed.dto.response.feed;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FeedLikeResponseDto {
    private Long feedId;
    private Long likeCount;
}
