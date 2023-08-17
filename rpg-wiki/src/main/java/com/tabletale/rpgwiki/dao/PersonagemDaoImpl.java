package com.tabletale.rpgwiki.dao;

import com.tabletale.rpgwiki.domain.Personagem;
import org.springframework.stereotype.Repository;

@Repository
public class PersonagemDaoImpl extends AbstractDao<Personagem, Long> implements PersonagemDao{
}
