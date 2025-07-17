package toolsforrpg_panpalianos.dominio.servicos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import toolsforrpg_panpalianos.dados.modelo.enums.Classe;
import toolsforrpg_panpalianos.dados.modelo.enums.Especializacao;
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
        boolean result = ValidadorFicha.validarEspecializacao(ficha);
        assertFalse(result);
        
        System.out.println("Especializacao certa");
        ficha.setEspecializacao(Especializacao.CACADOR);
        result = ValidadorFicha.validarEspecializacao(ficha);
        assertTrue(result);
        
        System.out.println("Nenhuma especializacao");
        ficha.setEspecializacao(Especializacao.NENHUMA);
        result = ValidadorFicha.validarEspecializacao(ficha);
        assertTrue(result);
        
        System.out.println("Especializacao nula");
        ficha.setEspecializacao(Especializacao.NENHUMA);
        result = ValidadorFicha.validarEspecializacao(ficha);
        assertTrue(result);
    }

    @Test
    public void testValidarAtributo(){
        assertTrue(ValidadorFicha.validarAtributo(0));
        assertTrue(ValidadorFicha.validarAtributo(50));
        assertFalse(ValidadorFicha.validarAtributo(-1));
        assertFalse(ValidadorFicha.validarAtributo(51));
    }

    @Test
    public void testValidarDadoVida(){
        FichaCriatura f = FichaCriatura.Builder.novaCriatura().build();

        f.setQuantDVs(2);
        assertTrue(ValidadorFicha.validarDadoDeVida(f));

        f.setQuantDVs(500);
        assertFalse(ValidadorFicha.validarDadoDeVida(f));
        
        f.setQuantDVs(-2);
        assertFalse(ValidadorFicha.validarDadoDeVida(f));

        FichaJogador fj = FichaJogador.Builder.novoJogador().build();

        fj.setLvl(1);
        (ValidadorFicha.validarDadoDeVida(fj));
        

    }

}
