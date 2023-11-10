# react-native-mobile-data-enabled

## Getting started

`$ npm install react-native-mobile-data-enabled`

### Manual installation

#### Android

1. Set newArchEnabled true if it isn't already in `android/gradle.properties`:
  	```
	  # Use this property to enable support to the new architecture.
	  # This will allow you to use TurboModules and the Fabric render in
	  # your application. You should enable this flag either if you want
	  # to write custom TurboModules/Fabric components OR use libraries that
	  # are providing them.
	  newArchEnabled=true
  	```

## Usage
```javascript
import RNMobileData from 'react-native-mobile-data-enabled/js/NativeMobileDataEnabled';

const isEnabled = await RNMobileData?.isEnabled();
console.log(isEnabled);
```
  