# Brique [![Build Status](https://travis-ci.org/valeriapaolucci/SDM_Brique.svg?branch=master)](https://travis-ci.org/valeriapaolucci/SDM_Brique)
## The project
This repository contains the *Software Development Methods* final project by Marco Alberto Grimaldi, Valeria Paolucci, Alberto Presta.

## Project structure
- **Data**: Package containing the elements representing the structure and the features of the game.
- **Logic**: Package containing the logic of the game.
- **CommandLine**: Package that implements the Command Line interface.
- **GraphicalUserInterface**: Package that implements the Graphical User interface.
- **Test**: Package containing all the tests.

## Rules
*Brique* is a simple two-player board game. Rules can be found [here](https://github.com/valeriapaolucci/SDM_Brique/edit/master//Rules.pdf).

## Game interfaces
The project is equipped with two main classes: *BriqueCL.java* (which manages the game with Command Line interface) and *BriqueGUI.java* (which manages the game with GUI).

## Graphical User Interface
We exploited the functionalities of *Swing* in order to provide a Graphical User Interface.
<br>A menu will show up containing the following buttons:
- **Single Player**: allowing a single player to compete vs. AI (actually it is not trained, so it's basically a random player).
- **Multiplayer**: allowing two players to compete against each other, alternating their turns.
- **Settings**: allowing you to set the players' names, your colour in case you choose to play with Single Player mode and the resolution.
- **Quit**: allowing you to leave the game.


## Command Line Interface
Our Command Line Interface shows a schematic representation of the board: rows are labeled with numbers *1-15*, columns with letters *a-o*. 
<br>When board squares are empty, a *#* symbol represents a white square, while the lack of *#* symbol represents a black square (as it has been designed having in mind a black terminal).
<br>When a black or white piece is put on a square, the symbol *B* or *W* is used respectively.
