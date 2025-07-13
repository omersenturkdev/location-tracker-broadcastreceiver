# Location Tracker App (Android - Kotlin)

This is a simple Android application written in Kotlin that detects whether the device's **location services (GPS)** are enabled or disabled. If GPS is turned off, the app shows a dialog prompting the user to enable it.

## 🚀 Features

- Checks if **GPS location service** is enabled on app start.
- If GPS is disabled, opens a dialog to redirect the user to **location settings**.
- Uses a **BroadcastReceiver** to detect runtime changes in location service state.
- Alerts the user again if GPS is turned off while the app is running.

## 📁 Project Structure

- `MainActivity.kt`: Contains the UI logic and location service check.
- `LocationChangeReceiver.kt`: Listens for location service state changes using `LocationManager.PROVIDERS_CHANGED_ACTION`.

## 🔧 How it works

- On `onCreate`, the app checks whether GPS is enabled.
- On `onResume`, it registers a BroadcastReceiver to listen to location service changes.
- If GPS is disabled anytime during app use, an **AlertDialog** appears prompting to enable it.
