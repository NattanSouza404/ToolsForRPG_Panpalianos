package toolsforrpg_panpalianos.dominio.servicos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import toolsforrpg_panpalianos.dados.modelo.enums.Classe;
import toolsforrpg_panpalianos.dados.modelo.enums.Especializacao;
import toolsforrpg_panpalianos.dados.modelo.enums.TipoAtributo;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

import static org.junit.Assert.*;

public class ValidadorFichaIT {
    
    public ValidadorFichaIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validarEspecializacao method, of class Validador.
     */
    @Test
    public void testValidarEspecializacao() {
        System.out.println("validarEspecializacao");
        
        FichaJogador ficha = FichaJogador.Builder.novoJogador().build();
        ficha.setClasse(Classe.CLERIGO);
        
        System.out.println("Especializacao errada");
        ficha.setEspecializacao(Especializacao.PALADINO);

        try {
            ValidadorFicha.validarEspecializacao(ficha);
            fail();
        } catch (Exception e){

        }
        
        System.out.println("Especializacao certa");
        ficha.setEspecializacao(Especializacao.CACADOR);

        try {
            ValidadorFicha.validarEspecializacao(ficha);
        } catch (Exception e){
            fail();
        }

        
        System.out.println("Nenhuma especializacao");
        ficha.setEspecializacao(Especializacao.NENHUMA);

        try {
            ValidadorFicha.validarEspecializacao(ficha);
        } catch (Exception e){
            fail();
        }
        
        System.out.println("Especializacao nula");
        ficha.setEspecializacao(Especializacao.NENHUMA);

        try {
            ValidadorFicha.validarEspecializacao(ficha);
        } catch (Exception e){
            fail();
        }
    }

    @Test
    public void testValidarAtributo(){
        FichaCriatura ficha = FichaCriatura.Builder.novaCriatura().forca(0).build();

        try {
            ValidadorFicha.validarAtributo(ficha, TipoAtributo.FORCA);
        } catch (Exception e){
            fail();
        }

        ficha.setForca(50);

        try {
            ValidadorFicha.validarAtributo(ficha, TipoAtributo.FORCA);
        } catch (Exception e){
            fail();
        }

        ficha.setForca(-1);

        try {
            ValidadorFicha.validarAtributo(ficha, TipoAtributo.FORCA);
            fail();
        } catch (Exception e){
            
        }

        ficha.setForca(51);

        try {
            ValidadorFicha.validarAtributo(ficha, TipoAtributo.FORCA);
            fail();
        } catch (Exception e){

        }
    }

    @Test
    public void testValidarDadoVida(){
        FichaCriatura f = FichaCriatura.Builder.novaCriatura().build();

        f.setQuantDVs(2);

        try {
            ValidadorFicha.validarDadoDeVida(f);
        } catch (Exception e){
            fail();
        }

        f.setQuantDVs(500);

        try {
            ValidadorFicha.validarDadoDeVida(f);
            fail();
        } catch (Exception e){

        }

        f.setQuantDVs(-2);

        try {
            ValidadorFicha.validarDadoDeVida(f);
            fail();
        } catch (Exception e){

        }

        FichaJogador fj = FichaJogador.Builder.novoJogador().build();

        fj.setLvl(1);

        try {
            ValidadorFicha.validarDadoDeVida(fj);
        } catch (Exception e){

        }
        
    }

}
