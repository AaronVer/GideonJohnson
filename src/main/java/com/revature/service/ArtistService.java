package com.revature.service;

import com.revature.dao.artistDAO;
import com.revature.model.Artist;

import java.sql.SQLException;
import java.util.List;

public class ArtistService {
    artistDAO artistdao;

    public ArtistService() {
        artistdao = new artistDAO();
    }
    public ArtistService(artistDAO dao) {
        artistdao = dao;
    }

    public List<Artist> getAllArtists(){
        try{
            return artistdao.getAllArtists();
        }catch(SQLException e){
            return null;
        }
    }

}