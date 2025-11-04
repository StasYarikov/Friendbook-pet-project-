# FriendBook

An Android social companion app designed for teens to connect with friends, discover gift ideas, and strengthen their inner circle. The app leverages the power of a Large Language Model (LLM) to provide a smart and personalized experience.

## Features

*   **Smart Matching:** Discover the percent of match between your friends to find their best options.
*   **Gift Idea Generator:** Struggling to find the perfect gift? Use the integrated AI to generate unique and personalized gift ideas for your friends.
*   **Inner Circle:** A dedicated space to keep your closest friends nearby and manage your most important connections.

## Tech Stack & Architecture

This app is built with modern Android development tools and a clean architecture approach:

*   **UI:** Jetpack Compose
*   **Asynchronous Programming:** Kotlin Flow / Coroutines
*   **Networking:** Retrofit for REST API communication
*   **Database:** Room for local data persistence
*   **AI Core:** Custom LLM API for intelligent features like gift generation and matching.

## Installation

1.  Clone the repository:
    ```bash
    git clone https://github.com/StasYarikov/Friendbook-pet-project-.git
    ```
2.  Open the project in Android Studio.
3.  Add your LLM API key to `local.properties`:
    ```properties
    LLM_API_KEY="your_api_key_here"
    ```
4.  Build and run the app on your device or emulator.

## Getting Started

Upon launching the app, you can create a profile and start adding friends. Use the "Generate Gift" feature by selecting a friend from your list to get AI-powered suggestions.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
