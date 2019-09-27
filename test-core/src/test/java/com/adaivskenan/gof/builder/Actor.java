package com.adaivskenan.gof.builder;
//Actor角色类：复杂产品，考虑到代码的可读性，只列出部分成员属性，且成员属性的类型均为String，真实情况下，有些成员属性的类型需自定义
class Actor {
	private String type; // 角色类型
	private String sex; // 性别
	private String face; // 脸型
	private String costume; // 服装
	private String hairstyle; // 发型

	public void setType(String type) {
		this.type = type;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public void setCostume(String costume) {
		this.costume = costume;
	}

	public void setHairstyle(String hairstyle) {
		this.hairstyle = hairstyle;
	}

	public String getType() {
		return (this.type);
	}

	public String getSex() {
		return (this.sex);
	}

	public String getFace() {
		return (this.face);
	}

	public String getCostume() {
		return (this.costume);
	}

	public String getHairstyle() {
		return (this.hairstyle);
	}
}