package com.whoiszxl.state;

import com.whoiszxl.entity.Order;
import com.whoiszxl.service.OrderService;

/**
 * 订单状态的抽象基类
 */
public abstract class AbstractOrderState implements OrderState {

    private OrderService orderService;

    public AbstractOrderState(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 待实现，获取订单的状态
     * @param order 订单信息
     * @return 订单状态码
     */
    protected abstract Integer getOrderStatus(Order order);

    @Override
    public void doTransition(Order order) {
        Integer orderStatus = getOrderStatus(order);
        order.setOrderStatus(orderStatus);
        orderService.updateStatus(order.getId(), orderStatus);
    }

    @Override
    public Boolean canPay(Order order) {
        return false;
    }

    @Override
    public Boolean canConfirmReceipt(Order order) {
        return false;
    }

    @Override
    public Boolean canCancel(Order order) {
        return false;
    }

    @Override
    public Boolean canApplyReturnProduct(Order order) {
        return false;
    }
}
