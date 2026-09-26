package com.substring.docmind.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchResultDto {

    private  String query;
    private  int totalMatches;
    private List<CitationDto> matches;

}
