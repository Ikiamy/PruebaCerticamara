package com.certicamara.test.validators;

import com.certicamara.test.exception.CommandParseException;
import com.certicamara.test.exception.OutLimitsException;
import com.certicamara.test.model.Surface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {

	public void validateCommand(String command) throws CommandParseException {
		String[] instructions;
		if (command == null)
			throw new CommandParseException();

		if (!command.contains(";"))
			throw new CommandParseException();

		instructions = command.split(";");
		for (int i = 0; i < instructions.length; i++) {
			validateMove(instructions[i]);
		}

	}

	private void validateMove(String move) throws CommandParseException {
		if (!move.matches("[0-99](.*)") || !move.matches("(.*),(.*)") || !move.matches("(.*)[A-Z]")) {
			throw new CommandParseException();
		}
	}

	public void validateMoveX(Surface surface, int amount) throws OutLimitsException {

		int gridX = surface.getGridSize().getX();
		int vehicleX = surface.getVehicleX();

		if ((gridX - amount) < 0 && (vehicleX + amount) > gridX)
			throw new OutLimitsException();
	}

	public void validateMoveY(Surface surface, int amount) throws OutLimitsException {

		int gridY = surface.getGridSize().getY();
		int vehicleY = surface.getVehicleY();

		if ((gridY - amount) < 0 && (vehicleY + amount) > gridY)
			throw new OutLimitsException();
	}
}
