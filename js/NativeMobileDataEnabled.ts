import type { TurboModule } from 'react-native/Libraries/TurboModule/RCTExport';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
    isEnabled(): Promise<boolean>;
}

export default TurboModuleRegistry.get<Spec>(
    'RNMobileDataEnabled',
) as Spec | null;