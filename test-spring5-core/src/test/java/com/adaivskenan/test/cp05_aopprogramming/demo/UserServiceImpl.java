package com.adaivskenan.test.cp05_aopprogramming.demo;
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("保存用户!");
        //int i = 1/0;
    }
    @Override
    public void delete() {
        System.out.println("删除用户!");
    }
    @Override
    public void update() {
        System.out.println("更新用户!");
    }
    @Override
    public void find() {
        System.out.println("查找用户!");
    }
}