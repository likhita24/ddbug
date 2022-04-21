// +build !ignore_autogenerated

/*
Copyright 2018 The Kubernetes Authors.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

// This file was autogenerated by conversion-gen. Do not edit it manually!

package v1alpha1

import (
	unsafe "unsafe"

	conversion "k8s.io/apimachinery/pkg/conversion"
	runtime "k8s.io/apimachinery/pkg/runtime"
	clusterregistry "k8s.io/cluster-registry/pkg/apis/clusterregistry"
)

func init() {
	localSchemeBuilder.Register(RegisterConversions)
}

// RegisterConversions adds conversion functions to the given scheme.
// Public to allow building arbitrary schemes.
func RegisterConversions(scheme *runtime.Scheme) error {
	return scheme.AddGeneratedConversionFuncs(
		Convert_v1alpha1_AuthInfo_To_clusterregistry_AuthInfo,
		Convert_clusterregistry_AuthInfo_To_v1alpha1_AuthInfo,
		Convert_v1alpha1_AuthProviderConfig_To_clusterregistry_AuthProviderConfig,
		Convert_clusterregistry_AuthProviderConfig_To_v1alpha1_AuthProviderConfig,
		Convert_v1alpha1_AuthProviderType_To_clusterregistry_AuthProviderType,
		Convert_clusterregistry_AuthProviderType_To_v1alpha1_AuthProviderType,
		Convert_v1alpha1_CloudProvider_To_clusterregistry_CloudProvider,
		Convert_clusterregistry_CloudProvider_To_v1alpha1_CloudProvider,
		Convert_v1alpha1_Cluster_To_clusterregistry_Cluster,
		Convert_clusterregistry_Cluster_To_v1alpha1_Cluster,
		Convert_v1alpha1_ClusterList_To_clusterregistry_ClusterList,
		Convert_clusterregistry_ClusterList_To_v1alpha1_ClusterList,
		Convert_v1alpha1_ClusterSpec_To_clusterregistry_ClusterSpec,
		Convert_clusterregistry_ClusterSpec_To_v1alpha1_ClusterSpec,
		Convert_v1alpha1_ClusterStatus_To_clusterregistry_ClusterStatus,
		Convert_clusterregistry_ClusterStatus_To_v1alpha1_ClusterStatus,
		Convert_v1alpha1_KubernetesAPIEndpoints_To_clusterregistry_KubernetesAPIEndpoints,
		Convert_clusterregistry_KubernetesAPIEndpoints_To_v1alpha1_KubernetesAPIEndpoints,
		Convert_v1alpha1_ServerAddressByClientCIDR_To_clusterregistry_ServerAddressByClientCIDR,
		Convert_clusterregistry_ServerAddressByClientCIDR_To_v1alpha1_ServerAddressByClientCIDR,
	)
}

func autoConvert_v1alpha1_AuthInfo_To_clusterregistry_AuthInfo(in *AuthInfo, out *clusterregistry.AuthInfo, s conversion.Scope) error {
	out.Providers = *(*[]clusterregistry.AuthProviderConfig)(unsafe.Pointer(&in.Providers))
	return nil
}

// Convert_v1alpha1_AuthInfo_To_clusterregistry_AuthInfo is an autogenerated conversion function.
func Convert_v1alpha1_AuthInfo_To_clusterregistry_AuthInfo(in *AuthInfo, out *clusterregistry.AuthInfo, s conversion.Scope) error {
	return autoConvert_v1alpha1_AuthInfo_To_clusterregistry_AuthInfo(in, out, s)
}

func autoConvert_clusterregistry_AuthInfo_To_v1alpha1_AuthInfo(in *clusterregistry.AuthInfo, out *AuthInfo, s conversion.Scope) error {
	out.Providers = *(*[]AuthProviderConfig)(unsafe.Pointer(&in.Providers))
	return nil
}

// Convert_clusterregistry_AuthInfo_To_v1alpha1_AuthInfo is an autogenerated conversion function.
func Convert_clusterregistry_AuthInfo_To_v1alpha1_AuthInfo(in *clusterregistry.AuthInfo, out *AuthInfo, s conversion.Scope) error {
	return autoConvert_clusterregistry_AuthInfo_To_v1alpha1_AuthInfo(in, out, s)
}

func autoConvert_v1alpha1_AuthProviderConfig_To_clusterregistry_AuthProviderConfig(in *AuthProviderConfig, out *clusterregistry.AuthProviderConfig, s conversion.Scope) error {
	out.Name = in.Name
	if err := Convert_v1alpha1_AuthProviderType_To_clusterregistry_AuthProviderType(&in.Type, &out.Type, s); err != nil {
		return err
	}
	out.Config = *(*map[string]string)(unsafe.Pointer(&in.Config))
	return nil
}

// Convert_v1alpha1_AuthProviderConfig_To_clusterregistry_AuthProviderConfig is an autogenerated conversion function.
func Convert_v1alpha1_AuthProviderConfig_To_clusterregistry_AuthProviderConfig(in *AuthProviderConfig, out *clusterregistry.AuthProviderConfig, s conversion.Scope) error {
	return autoConvert_v1alpha1_AuthProviderConfig_To_clusterregistry_AuthProviderConfig(in, out, s)
}

func autoConvert_clusterregistry_AuthProviderConfig_To_v1alpha1_AuthProviderConfig(in *clusterregistry.AuthProviderConfig, out *AuthProviderConfig, s conversion.Scope) error {
	out.Name = in.Name
	if err := Convert_clusterregistry_AuthProviderType_To_v1alpha1_AuthProviderType(&in.Type, &out.Type, s); err != nil {
		return err
	}
	out.Config = *(*map[string]string)(unsafe.Pointer(&in.Config))
	return nil
}

// Convert_clusterregistry_AuthProviderConfig_To_v1alpha1_AuthProviderConfig is an autogenerated conversion function.
func Convert_clusterregistry_AuthProviderConfig_To_v1alpha1_AuthProviderConfig(in *clusterregistry.AuthProviderConfig, out *AuthProviderConfig, s conversion.Scope) error {
	return autoConvert_clusterregistry_AuthProviderConfig_To_v1alpha1_AuthProviderConfig(in, out, s)
}

func autoConvert_v1alpha1_AuthProviderType_To_clusterregistry_AuthProviderType(in *AuthProviderType, out *clusterregistry.AuthProviderType, s conversion.Scope) error {
	out.Name = in.Name
	return nil
}

// Convert_v1alpha1_AuthProviderType_To_clusterregistry_AuthProviderType is an autogenerated conversion function.
func Convert_v1alpha1_AuthProviderType_To_clusterregistry_AuthProviderType(in *AuthProviderType, out *clusterregistry.AuthProviderType, s conversion.Scope) error {
	return autoConvert_v1alpha1_AuthProviderType_To_clusterregistry_AuthProviderType(in, out, s)
}

func autoConvert_clusterregistry_AuthProviderType_To_v1alpha1_AuthProviderType(in *clusterregistry.AuthProviderType, out *AuthProviderType, s conversion.Scope) error {
	out.Name = in.Name
	return nil
}

// Convert_clusterregistry_AuthProviderType_To_v1alpha1_AuthProviderType is an autogenerated conversion function.
func Convert_clusterregistry_AuthProviderType_To_v1alpha1_AuthProviderType(in *clusterregistry.AuthProviderType, out *AuthProviderType, s conversion.Scope) error {
	return autoConvert_clusterregistry_AuthProviderType_To_v1alpha1_AuthProviderType(in, out, s)
}

func autoConvert_v1alpha1_CloudProvider_To_clusterregistry_CloudProvider(in *CloudProvider, out *clusterregistry.CloudProvider, s conversion.Scope) error {
	out.Name = in.Name
	return nil
}

// Convert_v1alpha1_CloudProvider_To_clusterregistry_CloudProvider is an autogenerated conversion function.
func Convert_v1alpha1_CloudProvider_To_clusterregistry_CloudProvider(in *CloudProvider, out *clusterregistry.CloudProvider, s conversion.Scope) error {
	return autoConvert_v1alpha1_CloudProvider_To_clusterregistry_CloudProvider(in, out, s)
}

func autoConvert_clusterregistry_CloudProvider_To_v1alpha1_CloudProvider(in *clusterregistry.CloudProvider, out *CloudProvider, s conversion.Scope) error {
	out.Name = in.Name
	return nil
}

// Convert_clusterregistry_CloudProvider_To_v1alpha1_CloudProvider is an autogenerated conversion function.
func Convert_clusterregistry_CloudProvider_To_v1alpha1_CloudProvider(in *clusterregistry.CloudProvider, out *CloudProvider, s conversion.Scope) error {
	return autoConvert_clusterregistry_CloudProvider_To_v1alpha1_CloudProvider(in, out, s)
}

func autoConvert_v1alpha1_Cluster_To_clusterregistry_Cluster(in *Cluster, out *clusterregistry.Cluster, s conversion.Scope) error {
	out.ObjectMeta = in.ObjectMeta
	if err := Convert_v1alpha1_ClusterSpec_To_clusterregistry_ClusterSpec(&in.Spec, &out.Spec, s); err != nil {
		return err
	}
	out.Status = (*clusterregistry.ClusterStatus)(unsafe.Pointer(in.Status))
	return nil
}

// Convert_v1alpha1_Cluster_To_clusterregistry_Cluster is an autogenerated conversion function.
func Convert_v1alpha1_Cluster_To_clusterregistry_Cluster(in *Cluster, out *clusterregistry.Cluster, s conversion.Scope) error {
	return autoConvert_v1alpha1_Cluster_To_clusterregistry_Cluster(in, out, s)
}

func autoConvert_clusterregistry_Cluster_To_v1alpha1_Cluster(in *clusterregistry.Cluster, out *Cluster, s conversion.Scope) error {
	out.ObjectMeta = in.ObjectMeta
	if err := Convert_clusterregistry_ClusterSpec_To_v1alpha1_ClusterSpec(&in.Spec, &out.Spec, s); err != nil {
		return err
	}
	out.Status = (*ClusterStatus)(unsafe.Pointer(in.Status))
	return nil
}

// Convert_clusterregistry_Cluster_To_v1alpha1_Cluster is an autogenerated conversion function.
func Convert_clusterregistry_Cluster_To_v1alpha1_Cluster(in *clusterregistry.Cluster, out *Cluster, s conversion.Scope) error {
	return autoConvert_clusterregistry_Cluster_To_v1alpha1_Cluster(in, out, s)
}

func autoConvert_v1alpha1_ClusterList_To_clusterregistry_ClusterList(in *ClusterList, out *clusterregistry.ClusterList, s conversion.Scope) error {
	out.ListMeta = in.ListMeta
	out.Items = *(*[]clusterregistry.Cluster)(unsafe.Pointer(&in.Items))
	return nil
}

// Convert_v1alpha1_ClusterList_To_clusterregistry_ClusterList is an autogenerated conversion function.
func Convert_v1alpha1_ClusterList_To_clusterregistry_ClusterList(in *ClusterList, out *clusterregistry.ClusterList, s conversion.Scope) error {
	return autoConvert_v1alpha1_ClusterList_To_clusterregistry_ClusterList(in, out, s)
}

func autoConvert_clusterregistry_ClusterList_To_v1alpha1_ClusterList(in *clusterregistry.ClusterList, out *ClusterList, s conversion.Scope) error {
	out.ListMeta = in.ListMeta
	out.Items = *(*[]Cluster)(unsafe.Pointer(&in.Items))
	return nil
}

// Convert_clusterregistry_ClusterList_To_v1alpha1_ClusterList is an autogenerated conversion function.
func Convert_clusterregistry_ClusterList_To_v1alpha1_ClusterList(in *clusterregistry.ClusterList, out *ClusterList, s conversion.Scope) error {
	return autoConvert_clusterregistry_ClusterList_To_v1alpha1_ClusterList(in, out, s)
}

func autoConvert_v1alpha1_ClusterSpec_To_clusterregistry_ClusterSpec(in *ClusterSpec, out *clusterregistry.ClusterSpec, s conversion.Scope) error {
	if err := Convert_v1alpha1_KubernetesAPIEndpoints_To_clusterregistry_KubernetesAPIEndpoints(&in.KubernetesAPIEndpoints, &out.KubernetesAPIEndpoints, s); err != nil {
		return err
	}
	if err := Convert_v1alpha1_AuthInfo_To_clusterregistry_AuthInfo(&in.AuthInfo, &out.AuthInfo, s); err != nil {
		return err
	}
	out.CloudProvider = (*clusterregistry.CloudProvider)(unsafe.Pointer(in.CloudProvider))
	return nil
}

// Convert_v1alpha1_ClusterSpec_To_clusterregistry_ClusterSpec is an autogenerated conversion function.
func Convert_v1alpha1_ClusterSpec_To_clusterregistry_ClusterSpec(in *ClusterSpec, out *clusterregistry.ClusterSpec, s conversion.Scope) error {
	return autoConvert_v1alpha1_ClusterSpec_To_clusterregistry_ClusterSpec(in, out, s)
}

func autoConvert_clusterregistry_ClusterSpec_To_v1alpha1_ClusterSpec(in *clusterregistry.ClusterSpec, out *ClusterSpec, s conversion.Scope) error {
	if err := Convert_clusterregistry_KubernetesAPIEndpoints_To_v1alpha1_KubernetesAPIEndpoints(&in.KubernetesAPIEndpoints, &out.KubernetesAPIEndpoints, s); err != nil {
		return err
	}
	if err := Convert_clusterregistry_AuthInfo_To_v1alpha1_AuthInfo(&in.AuthInfo, &out.AuthInfo, s); err != nil {
		return err
	}
	out.CloudProvider = (*CloudProvider)(unsafe.Pointer(in.CloudProvider))
	return nil
}

// Convert_clusterregistry_ClusterSpec_To_v1alpha1_ClusterSpec is an autogenerated conversion function.
func Convert_clusterregistry_ClusterSpec_To_v1alpha1_ClusterSpec(in *clusterregistry.ClusterSpec, out *ClusterSpec, s conversion.Scope) error {
	return autoConvert_clusterregistry_ClusterSpec_To_v1alpha1_ClusterSpec(in, out, s)
}

func autoConvert_v1alpha1_ClusterStatus_To_clusterregistry_ClusterStatus(in *ClusterStatus, out *clusterregistry.ClusterStatus, s conversion.Scope) error {
	return nil
}

// Convert_v1alpha1_ClusterStatus_To_clusterregistry_ClusterStatus is an autogenerated conversion function.
func Convert_v1alpha1_ClusterStatus_To_clusterregistry_ClusterStatus(in *ClusterStatus, out *clusterregistry.ClusterStatus, s conversion.Scope) error {
	return autoConvert_v1alpha1_ClusterStatus_To_clusterregistry_ClusterStatus(in, out, s)
}

func autoConvert_clusterregistry_ClusterStatus_To_v1alpha1_ClusterStatus(in *clusterregistry.ClusterStatus, out *ClusterStatus, s conversion.Scope) error {
	return nil
}

// Convert_clusterregistry_ClusterStatus_To_v1alpha1_ClusterStatus is an autogenerated conversion function.
func Convert_clusterregistry_ClusterStatus_To_v1alpha1_ClusterStatus(in *clusterregistry.ClusterStatus, out *ClusterStatus, s conversion.Scope) error {
	return autoConvert_clusterregistry_ClusterStatus_To_v1alpha1_ClusterStatus(in, out, s)
}

func autoConvert_v1alpha1_KubernetesAPIEndpoints_To_clusterregistry_KubernetesAPIEndpoints(in *KubernetesAPIEndpoints, out *clusterregistry.KubernetesAPIEndpoints, s conversion.Scope) error {
	out.ServerEndpoints = *(*[]clusterregistry.ServerAddressByClientCIDR)(unsafe.Pointer(&in.ServerEndpoints))
	out.CABundle = *(*[]byte)(unsafe.Pointer(&in.CABundle))
	return nil
}

// Convert_v1alpha1_KubernetesAPIEndpoints_To_clusterregistry_KubernetesAPIEndpoints is an autogenerated conversion function.
func Convert_v1alpha1_KubernetesAPIEndpoints_To_clusterregistry_KubernetesAPIEndpoints(in *KubernetesAPIEndpoints, out *clusterregistry.KubernetesAPIEndpoints, s conversion.Scope) error {
	return autoConvert_v1alpha1_KubernetesAPIEndpoints_To_clusterregistry_KubernetesAPIEndpoints(in, out, s)
}

func autoConvert_clusterregistry_KubernetesAPIEndpoints_To_v1alpha1_KubernetesAPIEndpoints(in *clusterregistry.KubernetesAPIEndpoints, out *KubernetesAPIEndpoints, s conversion.Scope) error {
	out.ServerEndpoints = *(*[]ServerAddressByClientCIDR)(unsafe.Pointer(&in.ServerEndpoints))
	out.CABundle = *(*[]byte)(unsafe.Pointer(&in.CABundle))
	return nil
}

// Convert_clusterregistry_KubernetesAPIEndpoints_To_v1alpha1_KubernetesAPIEndpoints is an autogenerated conversion function.
func Convert_clusterregistry_KubernetesAPIEndpoints_To_v1alpha1_KubernetesAPIEndpoints(in *clusterregistry.KubernetesAPIEndpoints, out *KubernetesAPIEndpoints, s conversion.Scope) error {
	return autoConvert_clusterregistry_KubernetesAPIEndpoints_To_v1alpha1_KubernetesAPIEndpoints(in, out, s)
}

func autoConvert_v1alpha1_ServerAddressByClientCIDR_To_clusterregistry_ServerAddressByClientCIDR(in *ServerAddressByClientCIDR, out *clusterregistry.ServerAddressByClientCIDR, s conversion.Scope) error {
	out.ClientCIDR = in.ClientCIDR
	out.ServerAddress = in.ServerAddress
	return nil
}

// Convert_v1alpha1_ServerAddressByClientCIDR_To_clusterregistry_ServerAddressByClientCIDR is an autogenerated conversion function.
func Convert_v1alpha1_ServerAddressByClientCIDR_To_clusterregistry_ServerAddressByClientCIDR(in *ServerAddressByClientCIDR, out *clusterregistry.ServerAddressByClientCIDR, s conversion.Scope) error {
	return autoConvert_v1alpha1_ServerAddressByClientCIDR_To_clusterregistry_ServerAddressByClientCIDR(in, out, s)
}

func autoConvert_clusterregistry_ServerAddressByClientCIDR_To_v1alpha1_ServerAddressByClientCIDR(in *clusterregistry.ServerAddressByClientCIDR, out *ServerAddressByClientCIDR, s conversion.Scope) error {
	out.ClientCIDR = in.ClientCIDR
	out.ServerAddress = in.ServerAddress
	return nil
}

// Convert_clusterregistry_ServerAddressByClientCIDR_To_v1alpha1_ServerAddressByClientCIDR is an autogenerated conversion function.
func Convert_clusterregistry_ServerAddressByClientCIDR_To_v1alpha1_ServerAddressByClientCIDR(in *clusterregistry.ServerAddressByClientCIDR, out *ServerAddressByClientCIDR, s conversion.Scope) error {
	return autoConvert_clusterregistry_ServerAddressByClientCIDR_To_v1alpha1_ServerAddressByClientCIDR(in, out, s)
}
