package com.donghua.ssm.services;

import com.donghua.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    public void save(SysLog sysLog);

    List<SysLog> findAll();
}
