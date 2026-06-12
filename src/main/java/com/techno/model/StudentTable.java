package com.techno.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
@Entity
@Table
public class StudentTable {
	
	@Id
	@Column(name="sId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sId;
	@Column(name="name")
	private String name;
	@Lob
	@Column(length = 100000)
	private byte[] image;
	@Lob
	private char[] textdoc;
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public char[] getTextdoc() {
		return textdoc;
	}
	public void setTextdoc(char[] textdoc) {
		this.textdoc = textdoc;
	}
	@Override
	public String toString() {
		return "StudentTable [sId=" + sId + ", name=" + name + ", image=" + Arrays.toString(image) + ", textdoc="
				+ Arrays.toString(textdoc) + "]";
	}
	public StudentTable() {
		System.out.println("zero parameter constructor......");
	}
	

}
