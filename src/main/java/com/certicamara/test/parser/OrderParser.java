package com.certicamara.test.parser;

import com.certicamara.test.model.Command;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class OrderParser {

	public Command parse(String s) throws Exception {
		Command c = new Command();
		String[] couple = s.split(",");
		switch (couple[1]) {
		case "N":
			c.setDirection(Command.Direction.NORTH);
			break;
		case "S":
			c.setDirection(Command.Direction.SOUTH);
			break;
		case "E":
			c.setDirection(Command.Direction.EAST);
			break;
		case "W":
			c.setDirection(Command.Direction.WEST);
			break;
		default:
			throw new Exception("La direccion no es valida");
		}
		try {
			c.setAmount(Integer.parseInt(couple[0]));
		} catch (Exception e) {
			throw new Exception("La cantidad no es numerica");
		}
		return c;
	}

	public ArrayList<Command> parseList(String s) throws Exception {
		String[] orders = s.split(";");
		ArrayList<Command> commands = new ArrayList<>();
		for (String order : orders) {
			commands.add(parse(order));
		}
		return commands;
	}

}
