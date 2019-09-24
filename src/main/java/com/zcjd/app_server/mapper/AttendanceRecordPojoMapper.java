package com.zcjd.app_server.mapper;

import com.zcjd.app_server.model.AttendanceRecordPojo;
import com.zcjd.app_server.model.AttendanceRecordPojoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AttendanceRecordPojoMapper {
    long countByExample(AttendanceRecordPojoExample example);

    int deleteByExample(AttendanceRecordPojoExample example);

    int deleteByPrimaryKey(String id);

    int insert(AttendanceRecordPojo record);

    int insertSelective(AttendanceRecordPojo record);

    List<AttendanceRecordPojo> selectByExample(AttendanceRecordPojoExample example);

    AttendanceRecordPojo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AttendanceRecordPojo record, @Param("example") AttendanceRecordPojoExample example);

    int updateByExample(@Param("record") AttendanceRecordPojo record, @Param("example") AttendanceRecordPojoExample example);

    int updateByPrimaryKeySelective(AttendanceRecordPojo record);

    int updateByPrimaryKey(AttendanceRecordPojo record);
}