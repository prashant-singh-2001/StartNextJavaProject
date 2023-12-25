package com.startnext.bean;

import java.time.LocalDate;

public class StartupBean {
	private String name=null;
	private String field=null;
	private String founder=null;
	private String scope=null;
	private LocalDate start_date=null;
	private int id=0;
	private int likes=0;
	private int flags=0;
	private String image=null;
	private String spread=null;
	public StartupBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StartupBean(String name, String field, String founder, String scope, LocalDate start_date, int id, int likes,
			int flags, String image, String spread) {
		super();
		this.name = name;
		this.field = field;
		this.founder = founder;
		this.scope = scope;
		this.start_date = start_date;
		this.id = id;
		this.likes = likes;
		this.flags = flags;
		this.image = image;
		this.spread = spread;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getFounder() {
		return founder;
	}
	public void setFounder(String founder) {
		this.founder = founder;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getFlags() {
		return flags;
	}
	public void setFlags(int flags) {
		this.flags = flags;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSpread() {
		return spread;
	}
	public void setSpread(String spread) {
		this.spread = spread;
	}
	@Override
	public String toString() {
		return "StartupBean [name=" + name + ", field=" + field + ", founder=" + founder + ", scope=" + scope
				+ ", start_date=" + start_date + ", id=" + id + ", likes=" + likes + ", flags=" + flags + ", image="
				+ image + ", spread=" + spread + "]";
	}
	
}
