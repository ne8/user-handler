package ro.neo.userhandler.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ro.neo.userhandler.dto.UserDTO;
import ro.neo.userhandler.facades.UserFacade;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "User handler API for spring security projects",
        description = "User handler API that supports basic CRUD operations", tags = {"UserHandler"})
@RequestMapping(value = "/users/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private static final String USER_BY_EMAIL = "{email}/";

    @Autowired
    private UserFacade userFacade;


    @ApiOperation(
            value = "Retrieves all users from the database. Note that the password is hashed",
            response = UserDTO.class, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, responseContainer = "List", response = UserDTO.class, message = "User list retrieved successfully")})
    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UserDTO>> getAll() {
        LOGGER.debug("fetching users from the database");
        final List<UserDTO> userDTOList = this.userFacade.findAll();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @ApiOperation(
            value = "Retrieves one user from the database. Note that the password is hashed",
            response = UserDTO.class)
    @ApiResponses({
            @ApiResponse(code = 200, responseContainer = "List", response = UserDTO.class, message = "User retrieved successfully")})
    @RequestMapping(value = USER_BY_EMAIL, method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getByEmail(@PathVariable("email") final String email) {
        LOGGER.debug("fetching users from the database based on email");
        return new ResponseEntity<>(this.userFacade.getByEmail(email), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(@Valid @RequestBody final UserDTO userDTO, final UriComponentsBuilder ucBuilder) {
        LOGGER.debug("creating new user");
        this.userFacade.save(userDTO);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(userDTO.getNickname()).toUri());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @ApiOperation(
            value = "Removes user based on email",
            response = UserDTO.class)
    @ApiResponses({
            @ApiResponse(code = 200, responseContainer = "List", response = UserDTO.class, message = "User successfully removed")})
    @RequestMapping(value = USER_BY_EMAIL, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteByEmail(@PathVariable("email") final String email) {
        LOGGER.debug("removing user based on email");
        final UserDTO userDTO = this.userFacade.getByEmail(email);
        this.userFacade.delete(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
