# Practical exercise - The treasure map

This project simulates adventurers exploring a treasure map. It reads input data from a file, simulates the movements of adventurers, and generates an output file with the final state of the simulation.

## Requirements

- Java 8

## Usage

1. Compile the project:

   ```bash
   javac *.java
   ```

2. Run the simulation:

   ```bash
   java Main
   ```

   `input.txt` is the input file and `output.txt` the output file.

## Input Format

The input file input.txt should follow this format:

```
C - 3 - 4
M - 1 - 0
M - 2 - 1
T - 0 - 3 - 2
T - 1 - 3 - 3
A - Lara - 1 - 1 - S - AADADAGGA
```

- `C` defines the dimensions of the map.
- `M` defines the positions of mountains.
- `T` defines the positions of treasures.
- `A` defines the adventurers, their positions, orientations, and movements.

## Output Format

The output file output.txt will have the following format:

```
C - 3 - 4
M - 1 - 0
M - 2 - 1
# {T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Nb. de trésors restants}
T - 1 - 3 - 2
# {A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe vertical} - {Orientation} - {Nb. trésors ramassés}
A - Lara - 0 - 3 - S - 3
```

## Testing

Unit tests are provided for each class. You can run the tests using JUnit.

## Contributing

Feel free to contribute to this project by opening issues or submitting pull requests.
