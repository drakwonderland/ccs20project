# 🗡️ Group 7 - BSCS 1-A RPG Adventure

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Architecture diagram](https://gitdiagram.com/diagram-badge.svg)](https://gitdiagram.com/drakwonderland/ccs20project?utm_source=readme&utm_medium=badge)

A modular, text-based terminal RPG built in Java. Embark on an adventure starting from a secret tree house, explore village markets and dark dungeons, battle mythical creatures, and defeat the boss, **Sir Lester**.

---

## 🎮 Game Features

- **Character Customization**:
  - **3 Distinct Roles**: Mage, Fighter, and Tank with unique base HP, Defense, and Damage.
  - **Weapon Archetypes**: Distinct stat tradeoffs for each role (e.g., Crossbow burst, Sword & Shield fortress, Frost/Fire magic).
  - Custom name and gender selection with ASCII character profile previews.
- **Turn-Based Combat Engine**:
  - **Dynamic Visual Health Bars**: Custom block-rendered health bars (`[████████░░]`) with aligned HUDs.
  - **Tactical Choices**: Attack or Defend to mitigate incoming enemy damage.
  - **Monster Mechanics**: Werewolf Frenzy below 50% HP, Dirt Golem damage-blocking shields, and Necromancer Life Siphon healing.
- **Progression & Upgrades**:
  - Post-battle stat upgrades with hybrid health safety buffers.
  - Milestone rewards at the end of each difficulty tier.
- **3-Lives System**:
  - A life-based retry mechanic with instant full-health revival and Game Over handling.

---

## 🗺️ Adventure Stages

| Difficulty | Area | Enemies Encountered |
|---|---|---|
| **Easy** | Village Sceneries | Wild Slime *(Ambush)*, Goblin, Zombie |
| **Medium** | Forest Sceneries | Giant Serpent, Werewolf *(Frenzy)*, Dirt Golem *(Shields)* |
| **Hard** | Dungeon Sceneries | Drow *(Ambush)*, Necromancer *(Life Siphon)*, Red Dragon |
| **Boss** | Tree House Climax | **Sir Lester (The Boss)** |

---

## 🏗️ Project Architecture

[![Architecture diagram of drakwonderland/ccs20project](https://gitdiagram.com/drakwonderland/ccs20project/diagram.png)](https://gitdiagram.com/drakwonderland/ccs20project?utm_source=readme&utm_medium=picture)

### Class Breakdown

| Class | Description |
|---|---|
| [`Main.java`](Main.java) | Entry point that initializes scanner and runs the prologue and adventure sequence. |
| [`Player.java`](Player.java) | Centralized state store for player stats (HP, Def, Attack bonus, Lives, Role, Weapon). |
| [`CharacterCreation.java`](CharacterCreation.java) | Role selection, gender, name input, and weapon purchase logic. |
| [`Adventure.java`](Adventure.java) | Main storyline orchestration across Village, Forest, and Dungeon zones. |
| [`Battle.java`](Battle.java) | Turn-based combat loop, health bar generation, lives tracking, and victory upgrades. |
| [`GameText.java`](GameText.java) | Narrative dialogue, story sceneries, and decorative chapter banners. |
| [`Sprites.java`](Sprites.java) | ASCII character sprites for player roles and monsters. |
| [`Menu.java`](Menu.java) | Initial start/exit menu handling. |
| [`Clear.java`](Clear.java) | ANSI terminal screen-clearing utility with optional delays. |
| [`Pause.java`](Pause.java) | Prompt that pauses execution until the user presses `[ENTER]`. |

---

## 🚀 How to Run

### Prerequisites
- Java Development Kit (JDK 17 or higher recommended).

### Compilation & Execution

1. **Clone the repository:**
   ```bash
   git clone https://github.com/drakwonderland/ccs20project.git
   cd ccs20project
   ```

2. **Compile with UTF-8 encoding support:**
   ```bash
   javac -encoding UTF-8 *.java
   ```

3. **Run the game:**
   ```bash
   java Main
   ```

---

## 👥 Authors
- **Group 7 — BSCS 1-A**
- Project Repository: [drakwonderland/ccs20project](https://github.com/drakwonderland/ccs20project)
