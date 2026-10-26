# 🗡️ Group 7 - BSCS 1-A RPG Adventure
### Final Project in Introduction to Computer Science / Object-Oriented Programming

[![Java](https://img.shields.io/badge/Language-Java_17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Architecture diagram](https://gitdiagram.com/diagram-badge.svg)](https://gitdiagram.com/drakwonderland/ccs20project?utm_source=readme&utm_medium=badge)

A modular, text-based terminal RPG developed in Java by **BSCS 1-A Group 7**. This project demonstrates core 1st-year computer science fundamentals—moving from a monolithic script to a clean, modular, multi-class architecture featuring turn-based combat, ASCII art graphics, and dynamic state management.

---

## 🎯 Computer Science Concepts Demonstrated

During our presentation, our project showcases these core programming fundamentals:

1. **Modular Programming & Separation of Concerns (SoC)**:
   - Refactored a 1,000+ line monolithic `test.java` file into **10 specialized classes**, ensuring each file has one clear responsibility.
2. **State Management & Data Encapsulation**:
   - Centralized player variables ([`Player.java`](Player.java)) shared and manipulated across multiple gameplay modules ([`CharacterCreation.java`](CharacterCreation.java), [`Adventure.java`](Adventure.java), [`Battle.java`](Battle.java)).
3. **Turn-Based Combat Loops & Branching Logic**:
   - `while` loops managing turn order, ambush rounds, and conditional boss phases (Werewolf Frenzy, Golem Shields, Necromancer healing).
   - Modern `switch-case` statements with input normalization (`.trim().toLowerCase()`).
4. **Algorithmic Math & Clamping**:
   - Used `Math.max()` and `Math.min()` to calculate defensive damage mitigation, minimum chip damage, and safe proportional health bars.
5. **Terminal UI & Human-Computer Interaction (HCI)**:
   - Custom ASCII sprite rendering ([`Sprites.java`](Sprites.java)).
   - Dynamic Unicode progress bars (`[████████░░]`) calculated proportionally from current HP.
   - ANSI escape codes for seamless screen clearing ([`Clear.java`](Clear.java)).

---

## 🎮 Game Overview & Mechanics

### 1. Character Creation
- **3 Distinct Roles**:
  - 🧙 **Mage**: High burst damage, lower base defense.
  - ⚔️ **Fighter**: Balanced combatant with versatile weaponry.
  - 🛡️ **Tank**: High base defense, built to withstand heavy boss hits.
- **Weapon Archetypes**: Each weapon offers distinct tradeoffs (e.g., Crossbow offers high damage at the cost of defense; Sword & Shield provides defense).

### 2. Combat System
- **Aligned Combat HUD**: Symmetrical status display showing current HP, visual health bars, defense, and remaining lives.
- **Player Actions**: Choose to **[1] Attack** or **[2] Defend** (doubles effective defense for the round).
- **Unique Monster Mechanics**:
  - **Werewolf**: Enters a deadly **Frenzy (+7 ATK)** when below 50% HP.
  - **Dirt Golem**: Spawns with **2 stone shields** that completely negate damage.
  - **Necromancer**: Passively channels **Life Siphon (+5 HP)** each turn.
  - **Sir Lester (Boss)**: High-damage final boss with wild unpredictable swings.

### 3. Progression & 3-Lives System
- **Post-Battle Victory Upgrades**: Choose between Attack, Defense, or Health enhancements (with hybrid HP safety buffers to prevent soft-locks).
- **3-Lives Counter**: Players start with 3 lives. If defeated in battle, a life is consumed and the battle restarts. Running out of lives triggers a **Game Over**.

---

## 🗺️ Story Progression

```
[The Tree House] ──> [Village Market (Easy)] ──> [Forest (Medium)] ──> [Dungeon (Hard)] ──> [Final Boss: Sir Lester]
      Start                Slime / Goblin              Serpent / Golem       Necro / Dragon              Ending
```

---

## 🏗️ System Architecture

[![Architecture diagram of drakwonderland/ccs20project](https://gitdiagram.com/drakwonderland/ccs20project/diagram.png)](https://gitdiagram.com/drakwonderland/ccs20project?utm_source=readme&utm_medium=picture)

### Class Directory

| Class | Primary Responsibility |
|---|---|
| [`Main.java`](Main.java) | Program entry point; initializes global Scanner and runs the narrative pipeline. |
| [`Player.java`](Player.java) | Global data store holding runtime player attributes (HP, Def, ATK bonus, Lives). |
| [`CharacterCreation.java`](CharacterCreation.java) | Role selection, character naming, gender assignment, and weapon shop. |
| [`Adventure.java`](Adventure.java) | Narrative controller orchestrating zone progression and triggering battles. |
| [`Battle.java`](Battle.java) | Turn-based battle engine, health bar rendering, lives tracking, and upgrade choices. |
| [`GameText.java`](GameText.java) | Story dialog, stage transitions, and decorative ASCII headers. |
| [`Sprites.java`](Sprites.java) | ASCII art asset library for player classes and monsters. |
| [`Menu.java`](Menu.java) | Main entry menu (Start / Exit). |
| [`Clear.java`](Clear.java) | Cross-platform ANSI screen clearing with timed delays. |
| [`Pause.java`](Pause.java) | I/O flow control requiring user `[ENTER]` press before continuing. |

---

## 🚀 How to Run

1. **Open your terminal or command prompt in the project root folder.**
2. **Compile the Java files:**
   ```bash
   javac *.java
   ```
3. **Run the program:**
   ```bash
   java Main
   ```

---

## 👥 Contributors (BSCS 1-A — Group 7)

- [@drakwonderland](https://github.com/drakwonderland)
- [@starstruckraqun](https://github.com/starstruckraqun)
- [@eeesshheee](https://github.com/eeesshheee)
