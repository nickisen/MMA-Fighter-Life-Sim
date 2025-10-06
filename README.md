# Rise of the Fighter: MMA Fighter Life Sim

## Project Overview

"Rise of the Fighter" is an MMA fighter life simulation game for Android. Players take on the role of a new MMA fighter and must train, work, and fight their way to the top of the MMA world. The game features a detailed simulation of a fighter's life, including training, career management, and personal life.

## Architecture

This project follows the modern **MVVM (Model-View-ViewModel)** architecture, recommended by Google for building robust, maintainable, and testable Android apps. The key components of this architecture are:

* **View:** The UI layer of the application, composed of Activities and Fragments with their corresponding XML layouts. The View's responsibility is to display data to the user and pass user actions to the ViewModel.
* **ViewModel:** The ViewModel acts as a bridge between the View and the Repository. It holds and manages UI-related data and exposes it to the View via **LiveData**. This allows the UI to be automatically updated when the data changes, without the View having to be aware of the underlying data source.
* **Repository:** The Repository module is responsible for handling data operations. It abstracts the data sources (in this case, the **Room database**) from the rest of the app and provides a clean API for data access to the ViewModel.
* **Room Database:** Room is a persistence library that provides an abstraction layer over SQLite. It makes it easier to work with a local database while harnessing the full power of SQLite. All the game's data, including fighter stats, fight history, and game state, is stored in a Room database.

## Build Instructions

To build and run this project, follow these steps:

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/nickisen/mma-fighter-life-sim.git](https://github.com/nickisen/mma-fighter-life-sim.git)
    ```
2.  **Open in Android Studio:** Open the cloned project in the latest stable version of Android Studio.
3.  **Sync Gradle:** Let Android Studio sync the Gradle files. This will download all the necessary dependencies.
4.  **Run the app:** You can run the app on an Android emulator or a physical device with API level 24 or higher.

## Gameplay Guide

### Core Mechanics

* **Time:** The game progresses in weekly increments. Each week, you can perform various actions, such as training, working, or preparing for a fight.
* **Energy:** Energy is a crucial resource that is consumed by most actions. Your weekly energy pool resets at the beginning of each week. You can increase your energy cap by investing in your lifestyle, such as hiring a nutritionist.
* **Training:** You can train various skills, such as striking, grappling, and wrestling. The cost of training increases as your skill level improves. The quality of your gym also affects the efficiency of your training.
* **Fights:** The ultimate goal is to win fights and climb the ranks. Fight outcomes are determined by a sophisticated fight simulation engine that takes into account your fighter's stats, your opponent's stats, and a bit of luck.
* **Economy:** You will need to manage your finances to pay for training, gym memberships, and lifestyle improvements. You can earn money by working part-time jobs and winning fights.

### Fight Engine Explained

The fight simulation engine is a deterministic algorithm that calculates the outcome of a fight based on the stats of the two fighters. Here's a breakdown of how it works:

1.  **Effective Stats:** The engine first calculates the "effective" stats for each fighter in striking, grappling, and wrestling. This calculation takes into account the fighter's base stats, fatigue, and any active modifiers.
2.  **Overall Score:** An "effective overall" score is then calculated for each fighter. This is a weighted sum of their effective stats, with a strong emphasis on their `fightIQ` and `durability`.
3.  **Win Probability:** The win probability for each fighter is calculated using a `softmax` function on their effective overall scores. This ensures that the probabilities for both fighters add up to 100%. To keep fights exciting and unpredictable, there is a 5% "upset floor," meaning that even a heavy underdog has a small chance of winning.

This is just the beginning. In the next update, I will provide the code for the enhanced `FightEngine`, the new `ViewModel` classes, and the XML layouts for the new screens.
