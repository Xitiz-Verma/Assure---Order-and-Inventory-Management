package com.increff.toyAssure.api;

import com.increff.toyAssure.exception.ApiException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = ApiException.class)
public class OrderApi
{
}
