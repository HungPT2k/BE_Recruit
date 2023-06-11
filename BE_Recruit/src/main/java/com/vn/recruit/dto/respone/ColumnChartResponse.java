package com.vn.recruit.dto.respone;

import lombok.Data;

import java.util.List;

@Data
public class ColumnChartResponse {
    List<String> languages;

    List<Integer> totalRecruit;

    List<Integer> numberApply;


}
