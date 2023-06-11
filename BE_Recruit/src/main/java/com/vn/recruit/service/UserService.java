package com.vn.recruit.service;

import com.vn.recruit.dto.ResponseDTO;
import com.vn.recruit.dto.StatisticalDTO;
import com.vn.recruit.dto.UserDTO;
import com.vn.recruit.dto.respone.ColumnChartResponse;
import com.vn.recruit.dto.respone.LineChartDataResponse;
import com.vn.recruit.entity.User;
import com.vn.recruit.web.vm.SeachVM;
import com.vn.recruit.web.vm.StatisticalVm;
import com.vn.recruit.web.vm.UserProfileVM;

import java.io.IOException;
import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public User findById(Long id);
    public User findUserByUserName(String userName);
    public Object updateUser(User user);
    public List<User> seachUser(SeachVM seachVM);
    public Object changeThePassWord(UserDTO user);
    public Object deactivateUser(User user);
    public ResponseDTO addUserJe(UserDTO dto);
    public List<StatisticalDTO> statistical(StatisticalVm statisticalVm);
    public User saveUser(UserProfileVM user) throws IOException;
    public int getNumberUserJe();

    public LineChartDataResponse getDataLineChart(StatisticalVm statisticalVm);
    public ColumnChartResponse getDataColumnChart(StatisticalVm statisticalVm);
}
