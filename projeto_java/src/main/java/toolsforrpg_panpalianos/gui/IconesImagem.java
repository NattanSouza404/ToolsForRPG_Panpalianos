package toolsforrpg_panpalianos.gui;

import java.awt.Image;

import javax.swing.ImageIcon;

import lombok.Getter;

@Getter
public enum IconesImagem {

    LOGO("projeto_java/src/main/resources/images/capa_old_dragon.jpg"),
    ARMA("projeto_java/src/main/resources/images/icones/espada.png",20,20),
    ARMADURA("projeto_java/src/main/resources/images/icones/armaduras.png",20,20),
    ESCUDO("projeto_java/src/main/resources/images/icones/escudo.png",20,20),
    
    OLHO("projeto_java/src/main/resources/images/icones/olho-aberto.png",20,20),
    EDITAR("projeto_java/src/main/resources/images/icones/botao-editar.png",20,20),
    EXCLUIR("projeto_java/src/main/resources/images/icones/lixo.png",20,20),

    DADO("projeto_java/src/main/resources/images/icones/dado.png",20,20),

    SALVAR("projeto_java/src/main/resources/images/icones/salvar.png",20,20),
    ARQUIVO("projeto_java/src/main/resources/images/icones/arquivo.png", 20, 20);

    private ImageIcon imageIcon;

    IconesImagem(String path) {
        this.imageIcon = new ImageIcon(path);
    }

    IconesImagem(String path, int altura, int largura) {
        Image image = new ImageIcon(path).getImage();
        Image newimg = image.getScaledInstance(altura, largura,  java.awt.Image.SCALE_SMOOTH);
        this.imageIcon = new ImageIcon(newimg);
    }

    
}
