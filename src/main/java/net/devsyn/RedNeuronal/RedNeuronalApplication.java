package net.devsyn.RedNeuronal;

import net.devsyn.RedNeuronal.Entities.Perceptron;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Entrada al programa
 * @author Josema
 * @version 1.0
 */
@SpringBootApplication
public class RedNeuronalApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(RedNeuronalApplication.class, args);
		Perceptron p1=new Perceptron(3,4,true);
		Double entradas[]={p1.randomDouble(0,1),p1.randomDouble(0,1),p1.randomDouble(0,1)};
		p1.setEntradas(entradas);
		p1.asignarSalidas();
		System.out.println(p1.toString());

	}

}
