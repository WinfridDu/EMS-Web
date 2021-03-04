package com.ems.mapper;

import com.ems.domain.entity.Express;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/**
 * 快递信息的Dao
 *
 * @author dyf
 */
public interface ExpressMapper extends Mapper<Express> {
    @Update("update express set courier_tel = #{courierTel} where courier_num = #{courierNum}")
    void updateExpress(Express express);

    @Update("update express set status = 1, send_time = now() where courier_num = #{courierNum}")
    void updateStatus(String courierNum);
}
