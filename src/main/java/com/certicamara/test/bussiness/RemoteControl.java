package com.certicamara.test.bussiness;

import com.certicamara.test.exception.SurfaceNotInitializedException;
import com.certicamara.test.model.Coords;
import com.certicamara.test.model.Surface;
import com.certicamara.test.model.Command.Direction;
import com.certicamara.test.parser.OrderParser;
import com.certicamara.test.validators.OrderValidator;
import com.certicamara.test.model.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RemoteControl {

	@Autowired
	private OrderValidator validator;
	private OrderParser parser;
	private Surface surface;

	public RemoteControl() {

		this.validator = new OrderValidator();
		this.parser = new OrderParser();

	}

	public Coords initializeSurface(int m, int n) throws Exception {
		if (m <= 0)
			throw new Exception("El valor de M (X) no puede ser menor o igual a 0");
		if (n <= 0)
			throw new Exception("El valor de N (Y) no puede ser menor o igual a 0");
		this.surface = new Surface(m, n);
		return this.surface.getGridSize();
	}

	public String moveVehicle(String commands) throws Exception {
		if (this.surface.getVehiclePosition() == null)
			throw new SurfaceNotInitializedException();

		ArrayList<Command> commandList;
		int gridX = surface.getVehicleX();
		int gridY = surface.getVehicleY();

		try {
			validator.validateCommand(commands);
			commandList = parser.parseList(commands);
		} catch (Exception e) {
			throw e;
		}

		for (Command command : commandList) {

			if (command.getDirection() == Direction.NORTH || command.getDirection() == Direction.SOUTH)
				validator.validateMoveY(surface, command.getAmount());

			if (command.getDirection() == Direction.EAST || command.getDirection() == Direction.WEST)
				validator.validateMoveX(surface, command.getAmount());

			switch (command.getDirection()) {
			case NORTH:
				this.surface.setVehicleY(gridY + command.getAmount());
				break;
			case EAST:
				this.surface.setVehicleX(gridX + command.getAmount());
				break;
			case SOUTH:
				this.surface.setVehicleY(gridY - command.getAmount());
				break;
			default:
				this.surface.setVehicleX(gridX - command.getAmount());
				break;
			}

			if(command!=null)
			writeVehiclePosition();
		}
		
		return this.surface.getMovements().toString();
	}

	public Coords getVehiclePosition() throws SurfaceNotInitializedException {
		if (this.surface.getVehiclePosition() == null)
			throw new SurfaceNotInitializedException();
		return this.surface.getVehiclePosition();
	}

	private void writeVehiclePosition() {
		surface.getMovements().append("(" + surface.getVehicleX() + "," + surface.getVehicleY() + ")\n");
	}
}
