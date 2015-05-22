package com.zhou.account.bean;

import java.util.HashSet;
import java.util.Set;

import com.zhou.song.bean.Album;
import com.zhou.song.bean.ArtType;
import com.zhou.song.bean.Song;

public class SingerAccount extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = 837256776239388085L;
	/**
	 * 歌手简介
	 * 
	 */
	private String presentation;
	private int heat;
	private Set<ArtType> artTypes=new HashSet<ArtType>();
	private Set<Song> songs=new HashSet<Song>();
	private Set<Album> albums=new HashSet<Album>();
	
	
	public Set<Album> getAlbums() {
		return albums;
	}
	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}
	public Set<Song> getSongs() {
		return songs;
	}
	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}
	public Set<ArtType> getArtTypes() {
		return artTypes;
	}
	public void setArtTypes(Set<ArtType> artTypes) {
		this.artTypes = artTypes;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public int getHeat() {
		return heat;
	}
	public void setHeat(int heat) {
		this.heat = heat;
	}
	public SingerAccount() {
		super();
		this.setType(AccountTypes.SINGER.name());
	}
	@Override
	public String toString() {
		return "SingerAccount [presentation=" + presentation + ", heat=" + heat
				+ ", toString()=" + super.toString() + "]";
	}
	
}
