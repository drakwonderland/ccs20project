# 🗡️ BS-CS Heroic Adventure
### Final Project in Introduction to Computer Science / Object-Oriented Programming
**BSCS 1-A — Group 7**

[![Java](https://img.shields.io/badge/Language-Java_17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Architecture diagram](https://gitdiagram.com/diagram-badge.svg)](https://gitdiagram.com/drakwonderland/ccs20project?utm_source=readme&utm_medium=badge)

**BS-CS Heroic Adventure** is a modular, text-based terminal RPG developed in Java by **BSCS 1-A Group 7**. This project demonstrates core 1st-year computer science and object-oriented fundamentals through a clean, 10-class architecture featuring turn-based combat, dynamic terminal frame refreshing, comprehensive ASCII art graphics, and robust state management.

---

## 🎯 Computer Science Concepts Demonstrated

1. **Modular Architecture & Separation of Concerns (SoC)**:
   - Decomposed gameplay, user interface, combat mechanics, and data models across **10 specialized classes**, ensuring each file has a single, cohesive responsibility.
2. **Centralized State Management & Data Encapsulation**:
   - Centralized player variables in [`Player.java`](Player.java) accessed and mutated across gameplay modules ([`CharacterCreation.java`](CharacterCreation.java), [`Adventure.java`](Adventure.java), [`Battle.java`](Battle.java)).
3. **Turn-Based Combat Loops & Dynamic Frame Refresh**:
   - `while` combat cycles featuring active turn sequences, surprise ambush rounds, anchored monster sprites, real-time HP bar updates, and life revival logic.
4. **Algorithmic Math & Clamping**:
   - Utilized `Math.max()` and `Math.min()` for defensive damage mitigation, minimum chip damage, and safe proportional health bars (`[████████░░]`).
5. **Terminal Human-Computer Interaction (HCI)**:
   - Rich ASCII sprite art library for character classes, weapons, and monsters ([`Sprites.java`](Sprites.java)).
   - Cross-platform ANSI screen clearing with timed delays ([`Clear.java`](Clear.java)).
   - User-paced I/O flow control requiring `[ENTER]` confirmations ([`Pause.java`](Pause.java)).

---

## 🎮 Game Overview & Mechanics

### 1. Character Creation & Armory
- **3 Distinct Roles**:
  - 🧙 **Mage**: High spell damage with 10 Base HP and 3 Base Defense.
  - ⚔️ **Fighter**: Balanced combatant with 12 Base HP and 4 Base Defense.
  - 🛡️ **Tank**: High survivability with 15 Base HP and 5 Base Defense.
- **Role-Specific Weapon Armory**:
  - **Fighter**: Bow (+11 ATK, +1 DEF), Sword (+10 ATK, +2 DEF), Crossbow (+13 ATK, -1 DEF)
  - **Tank**: Sword & Shield (+7 ATK, +4 DEF), Warhammer (+8 ATK, +3 DEF), Polearm (+10 ATK, +2 DEF)
  - **Mage**: Ice Wand (+11 ATK, +2 DEF), Fire Staff (+14 ATK)

### 2. Combat System & Dynamic Turn Refresh
- **Anchored Monster Display**: Monster ASCII art remains anchored at the top of the terminal while its health bar dynamically updates below each turn.
- **Combat HUD**: Symmetrical status display tracking player HP, visual gauge, Defense, and remaining Lives.
- **Player Actions**:
  - **[1] Attack**: Deal weapon damage boosted by role stats and enemy defense mitigation.
  - **[2] Defend**: Braces for incoming blows, doubling effective defense for the round.
- **Unique Monster Mechanics & Passives**:
  - 🟢 **Slime / Drow**: Launch surprise **Ambushes**, landing a preemptive strike before player reaction.
  - 🐺 **Werewolf**: Enters **Frenzy (+7 ATK)** when falling below 50% HP.
  - 🗿 **Dirt Golem**: Spawns with **2 Stone Shields** that completely nullify initial attacks.
  - 💀 **Necromancer**: Passively channels **Life Siphon (+5 HP)** each turn to restore health.
  - 🐉 **Red Dragon**: High-damage encounter with devastating Fire Breath.
  - 👑 **Sir Lester (The Boss)**: Climax final boss encounter with dedicated ASCII art and unpredictable heavy blows.

### 3. Progression & 3-Lives System
- **Post-Battle Victory Upgrades**: Choose between Attack bonuses, Defense enhancements, or Health increases (with safety HP buffers).
- **Difficulty Cleared Milestones**: Major stat boosts awarded upon clearing Village, Forest, and Dungeon zones.
- **3-Lives Counter**: Players possess 3 lives. Falling in battle consumes 1 life and restarts the encounter; running out triggers a **Game Over**.

---

## 🗺️ Story Progression

```
[Act I: Village Sceneries (Easy)]
  ├── 1. The Tree House (The Beginning & Role Selection)
  ├── 2. Departure for the Village Market
  ├── 3. The Market (Weapon Acquisition)
  ├── 4. The Slime (Ambush Encounter)
  ├── 5. The Goblin
  └── 6. The Zombie

[Act II: Forest Sceneries (Medium)]
  ├── 7. The Serpent (Rest at the Lake)
  ├── 8. The Werewolf (Berry Bush Encounter - Frenzy Mode)
  └── 9. The Dirt Golem (Ancient Tree - Shield Mechanic)

[Act III: Dungeon Sceneries (Hard)]
  ├── 10. The Drow (Ambush in Wilderness)
  ├── 11. The Necromancer (Life Siphon Duel)
  └── 12. The Red Dragon (Crystal Hoard)

[Climax & Epilogue]
  ├── 13. The Final Battle: Sir Lester (The Boss)
  └── 14. Ending & The End
```

---

## 🏗️ System Architecture

[![Architecture diagram of drakwonderland/ccs20project](https://gitdiagram.com/drakwonderland/ccs20project/diagram.png)](https://gitdiagram.com/drakwonderland/ccs20project?utm_source=readme&utm_medium=picture)

### Class Directory

| Class | Primary Responsibility |
|---|---|
| [`Main.java`](Main.java) | Program entry point; initializes global Scanner and runs the narrative pipeline. |
| [`Player.java`](Player.java) | Central data store holding runtime player attributes (HP, Def, ATK bonus, Lives, Role, Weapon, Name, Gender). |
| [`CharacterCreation.java`](CharacterCreation.java) | Role selection with stat cards, gender and name input, summary confirmation, and weapon armory. |
| [`Adventure.java`](Adventure.java) | Narrative controller orchestrating zone progression and triggering battles. |
| [`Battle.java`](Battle.java) | Turn-based combat engine, frame refreshes, health bars, boss mechanics, lives tracker, and rewards. |
| [`GameText.java`](GameText.java) | Story dialog, stage transitions, and decorative headers. |
| [`Sprites.java`](Sprites.java) | ASCII art asset library for player classes, 7 weapon types, and 9 monster encounters (including Sir Lester). |
| [`Menu.java`](Menu.java) | Main entry menu (Start / Exit) with input validation. |
| [`Clear.java`](Clear.java) | Cross-platform ANSI screen clearing with timed delays. |
| [`Pause.java`](Pause.java) | Flow controller pausing execution until the user presses `[ENTER]`. |

---

## 🚀 How to Run

1. **Open your terminal or command prompt in the project root folder.**
2. **Compile the Java source files:**
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
