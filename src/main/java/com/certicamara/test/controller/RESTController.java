package com.certicamara.test.controller;

import com.certicamara.test.bussiness.RemoteControl;
import com.certicamara.test.exception.CommandParseException;
import com.certicamara.test.exception.SurfaceNotInitializedException;
import com.certicamara.test.model.PositionResponse;
import com.certicamara.test.model.Coords;
import com.certicamara.test.model.MovementsResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("car")
public class RESTController {

	@Autowired
	private RemoteControl control;

	@PostMapping(value = "initialize")
	public ResponseEntity<PositionResponse> initialize(@Valid @RequestBody Coords request) {
		try {
			return new ResponseEntity<>(
					new PositionResponse(control.initializeSurface(request.getX(), request.getY()), null),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(new PositionResponse(null, e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "move")
	public ResponseEntity<MovementsResponse> moveCar(@Valid @RequestBody String commands) throws Exception {
		try {
			return new ResponseEntity<>(new MovementsResponse(control.moveVehicle(commands), null), HttpStatus.OK);
		} catch (SurfaceNotInitializedException e) {
			return new ResponseEntity<>(new MovementsResponse(null, e.getMessage()), HttpStatus.PRECONDITION_FAILED);
		} catch (CommandParseException e) {
			return new ResponseEntity<>(new MovementsResponse(null, e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "getPosition")
	public ResponseEntity<PositionResponse> getPosition() {
		try {
			return new ResponseEntity<>(new PositionResponse(control.getVehiclePosition(), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new PositionResponse(null, e.getMessage()), HttpStatus.PRECONDITION_FAILED);
		}
	}
}
