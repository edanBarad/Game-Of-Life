# Game of Life

A Java implementation of Conway's Game of Life. This program generates a grid of cells, each of which can be alive or dead. The game evolves in steps, with each step determined by the number of alive neighbors each cell has.

## How It Works

Conway's Game of Life is a cellular automaton devised by the British mathematician John Horton Conway in 1970. The game is a zero-player game, meaning that its evolution is determined by its initial state, needing no further input. One interacts with the Game of Life by creating an initial configuration and observing how it evolves.

## Rules

1. Any live cell with fewer than two live neighbors dies, as if by underpopulation.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

## Getting Started

### Prerequisites

- Java JDK 8 or higher

### Running the Program
