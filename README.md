# Brique
## The project
This repository contains the *Software Development Methods* final project by Marco Alberto Grimaldi, Valeria Paolucci, Alberto Presta.

## Project structure
- Logic: Package containing all the logic of the game, from the board to the rules of the game.
- CLI: Package that manages the game flow and the interface from Command Line.
- GUI: Package that manages the game flow and the interface from the GUI.
- Test: Package containing all the tests.

## Rules
*Brique* is a simple two-player board game. Rules can be found [here](https://github.com/MarcoAlbertoGrimaldi/BriqueGUI/edit/master/Rules.pdf).


## How to run the project
...
<br>You will be asked whether you want to play with the Graphical User Interface: you can type *yes* if you prefer to play with the GUI or *no* if you prefer the Command Line Interface.

## GUI
We exploited the functionalities of *JFrame* in order to provide a Graphical User Interface.
<br>A menu will show up containing the following buttons:
- **Single Player**: allowing a single player to compete vs. AI.
- **Multiplayer**: allowing two players to compete against each other, alternating their turns.
- **Settings**: allowing you to set the players' names, your colour in case you choose to play with Single Player mode, the resolution.
- **Quit**: allowing you to leave the game.


## Command Line Interface
Our Command Line Interface shows a schematic representation of the board: rows are labeled with numbers *1-15*, columns with letters *a-o*. 
<br>When board squares are empty, a *#* symbol represents a white square, while the lack of *#* symbol represents a black square (as it has been designed having in mind a black terminal).
<br>When a black or white piece is put on a square, the symbol *B* or *W* is used respectively.
